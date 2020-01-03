pipeline {
  agent any
  stages {
    stage('Complie') {
      steps {
        dir(path: 'pact-consumer') {
          sh 'mvn clean install'
        }

      }
    }

    stage('Sonar Scan') {
      steps {
        sh 'echo "Sonar Scan"'
      }
    }

    stage('Running Consumer Generate Pact ') {
      steps {
        dir(path: 'pact-consumer') {
          sh 'mvn test'
        }

      }
    }

    stage('Start PactBroker') {
      steps {
        dir(path: 'pact-broker') {
          sh 'sudo /usr/local/bin/docker-compose up -d'
        }

      }
    }

    stage('Publish PactBroker') {
      steps {
        dir(path: 'pact-consumer') {
          sh 'mvn pact:publish'
        }

      }
    }

    stage('Close PactBroker') {
      steps {
        dir(path: 'pact-broker') {
          sh 'sudo /usr/local/bin/docker-compose down'
        }

      }
    }

    stage('Build Consumer Docker') {
      steps {
        dir(path: 'pact-consumer') {
          sh '/usr/local/bin/docker build -t pact-consumer .'
        }

      }
    }

    stage('Publish Consumer To Repository') {
      steps {
        dir(path: 'pact-consumer') {
          sh '/usr/local/bin/docker login -u feihuo55 -p 20010413guo'
          sh '/usr/local/bin/docker tag $(/usr/local/bin/docker images --filter=reference=pact-consumer --format "{{.ID}}") feihuo55/cdcdemo'
          sh '/usr/local/bin/docker push feihuo55/cdcdemo'
        }

      }
    }

  }
}