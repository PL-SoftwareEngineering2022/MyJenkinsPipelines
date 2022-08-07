CODE_CHANGES = getGitChanges() //<== can be set here globally and checks if there are code changes and sets the value of the boolean
pipeline { 
    agent any 
    stages { 
        stage("build") {
            when{
                expression {
                    BRANCH_NAME == 'dev' && CODE_CHANGES == true // executes if the branch is dev and there are code changes
                }
            }
            steps {
                echo 'building the application'
                sh 'mvn package'
            }
        }

        stage("test") {
            when {
                expression {
                    env.BRANCH_NAME == 'dev' // this stage will only execute if the current branch is 'dev' if not, it will skip
                    //BRANCH_NAME 
                }
            }
            steps {
                echo 'testing the application'
            }
        }

        stage("deploy") {
            when {
                expression {
                    BRANCH_NAME == 'dev' || BRANCH_NAME == 'master' // will execute if the branch is 'dev' OR 'master'
                }
            }
            steps{
                 echo 'deploying the application'
                
            }
        }
    }
}