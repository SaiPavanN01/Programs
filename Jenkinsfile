pipeline{
    agent any
    tools {
            jdk 'JDK 21'
        }
    triggers{
        pollSCM '*/5 * * * *'
    }
        stages{
            stage('build'){
                steps{
                    sh 'javac -d BinarySearch/target/classes BinarySearch/src/main/java/io/pavan/CeilingNumber.java'
                }
            }
            stage('test'){
                steps{
                    sh 'java -cp BinarySearch/target/classes io.pavan.CeilingNumber'
                }
            }
            stage('deploy'){
                steps{
                    echo "Deploying the application"
                }
            }
        }
}