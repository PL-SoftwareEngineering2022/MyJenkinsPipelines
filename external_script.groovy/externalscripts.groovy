def gv

pipeline { 
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.0.0', '1.0.1', '1.0.2'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    } 

    stages {   
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
                echo 'building the application'
                //sh 'mvn package'
            }
        } 

        stage("build") {
            steps {
                script {
                    gv.buildApp() //variable name and function name
                }
            }
        } 

        stage("test") {
            when {
                expression {
                  params.executeTests == true 
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }

        stage("deploy") {
            steps{
                script {
                    gv.deployApp()
                }            
            }
        }   
    }    
}
