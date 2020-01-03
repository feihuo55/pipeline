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
          sh 'sudo /usr/local/bin/docker-compose up'
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
          sh 'docker build -t pact-consumer .'
        }

      }
    }

    stage('Publish Consumer To Repository') {
      steps {
        dir(path: 'pact-consumer') {
          sh 'docker tag $(docker images --filter=reference=pact-consumer --format "{{.ID}}") feihuo55/cdcdemo'
        }

        sh 'docker push feihuo55/cdcdemo'
      }
    }

  }
}