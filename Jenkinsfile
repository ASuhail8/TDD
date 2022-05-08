pipeline {
    agent any
    parameters {
        choice choices: ['CHROME','FIREFOX','EDGE'], name: 'BROWSER'
        string defaultValue: 'DEV', description: 'Environment details.', name: 'ENV', trim: true
            }        

    stages {   
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
            echo "Starting the tests on ${params.ENV} Selected browser is ${params.BROWSER}"
            sh "mvn -DBROWSER=${params.BROWSER} test"
        }
        post {
            always {
                junit 'target/surefire-reports/*.xml'
                emailext attachLog: true, body: '$DEFAULT_CONTENT', subject: '$DEFAULT_SUBJECT', to: '$DEFAULT_RECIPIENTS'
                cleanWs()
            }
        }
    } 
    } 
}