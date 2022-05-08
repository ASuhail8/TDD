pipeline {
    agent any
    parameters {
        choice choices: ['CHROME','FIREFOX','EDGE'], name: 'BROWSER'
            }        

    stages {
    stage('Start the docker container'){
        steps{
        sh 'docker-compose up'
        sh 'sleep 1'
        }
    }    
    stage('Package jar and release artifacts') {
        steps {
            sh 'mvn clean package -DskipTests'
        }
        post {
            always {
                archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
            }
        }
    }
    stage('Run the automated test') {
        steps {
            echo "Selected param is ${params.BROWSER}"
            sh "mvn -DBROWSER=${params.BROWSER} test"
        }
        post {
            always {
                junit 'target/surefire-reports/junitreports/*.xml'
                emailext attachLog: true, attachmentsPattern: 'target/surefire-reports/*.xml', body: '$DEFAULT_CONTENT', subject: '$DEFAULT_SUBJECT', to: '$DEFAULT_RECIPIENTS'
                sh 'docker-compose down'
            }
        }
    } 
    } 
}