pipeline { // must be top level;

    agent any //where to execute

    stages { //where the "work" happens

        stage("build") {
            steps {
                echo 'building the application'
                //sh 'mvn package'
            }
        }

        stage("test") {
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