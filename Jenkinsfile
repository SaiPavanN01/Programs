pipeline{
    agent any
    triggers{
        pollSCM '*/5 * * * *'
    }
        stages{
            stage('build'){
                steps{
                    javac Main.java
                }
            }
            stage('test'){
                steps{
                    java Main
                }
            }
            stage('deploy'){
                steps{
                    echo "Deploying the application"
                }
            }
        }
}