pipeline{

    agent any

        stages{

            stage('Build Jar'){
                steps{
                    bat "mvn clean package -DskipTests"
                }
            }

            stage('Build Image'){
                steps{
                    bat "docker build -t=syedanwer1997/alfatkg ."
                }
            }

            stage('Push Image'){
                steps{
                    bat "docker push syedanwer1997/alfatkg"
                }
            }
        }
}