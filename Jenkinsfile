pipeline {
    agent any
    parameters {
  choice choices: ['CHROME','FIREFOX', 'EDGE'], name: 'BROWSER'
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
            sh "mvn -DBROWSER=$BROWSER test"
        }
        post {
            always {
                junit 'target/surefire-reports/junitreports/*.xml'
            }
        }
    } 
    } 
}