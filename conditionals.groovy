pipeline { 
    agent any 
    stages { 
        stage("build") {
            steps {
                echo 'building the application'
                sh 'mvn package'
            }
        }

        stage("test") {
            when {
                expression {
                    
                }
            }
            steps {
                echo 'testing the application'
            }
        }

        stage("deploy") {
            steps{
                 echo 'deploying the application'
                
            }
        }
    }
}