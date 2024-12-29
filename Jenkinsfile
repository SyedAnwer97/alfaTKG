pipeline{
    agent any
    stages{
        stage('build java jar'){
            steps{
            bat "mvn clean package -DskipTests"
            }
        }
        stage('build docker image'){
            steps{
            bat "docker build -t=syedanwer1997/alfatkg ."
            }
        }
        stage('push docker image'){
        environment{
            DOCKER_HUB = credentials('dockerhub-cred')
        }
            steps{
            bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
            bat "docker push syedanwer1997/alfatkg"
            }
        }
    }
    post{
        always{
            bat "docker logout"
        }
    }
}