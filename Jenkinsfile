pipeline{
    agent any
    stages{
        stage('build java jar'){
            steps{
            bat 'mvn clean package -DskipTests'
            }
        }
        stage('build docker image'){
            steps{
            bat 'docker build -t=syedanwer1997/alfatkg .'
            }
        }
        stage('push docker image'){
            steps{
            bat 'docker push syedanwer1997/alfatkg'
            }
        }
    }
}