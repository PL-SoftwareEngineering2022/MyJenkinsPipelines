pipeline { 
    agent any 
    environment{ //any variables defined here will be available to the rest of the pipeline. eg. a version.
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials()// can be fined globally or at the stage the credentials are going to be used.
    }

    stages { 
        stage("build") {
            steps {
                echo 'building the application'
                echo "building version ${NEW_VERSION}"
            }
        }

    }
}

Please note that if you use an enviromnmental variable in groovy, you need to use double quotes, not single quotes: 
- However, you can use single quotes if it is just a simple string. 
    echo 'building version ${NEW_VERSION}'
    echo "building version ${NEW_VERSION}"