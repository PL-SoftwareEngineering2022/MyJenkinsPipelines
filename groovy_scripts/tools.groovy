pipeline { 
    agent any 
     tools {
        maven 'maven3.8.6' //name given to the build tool in Jenkins
    }
    stages { 
       
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

Tools attribute:
- provides you with build tools for your projects
- there are currently three build tools available: maven, gradle, jdk. 
    - If you need tools like Yarn etc. you will have to install these tools directly on the Jenkins server
- you define the tool in the pipeline and it has to have been preinstalled in Jenkins. Check under Global tool configuration on the GUI
