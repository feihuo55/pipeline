pipeline {
  agent any
  stages {
    stage('Compile') {
      steps {
        sh 'mvn clean compile'
      }
    }

    stage('BuildProvider') {
      steps {
        dir(path: 'pact-provider') {
          sh 'nohup mvn spring-boot:run &'
        }

      }
    }

    stage('VerifyPact') {
      steps {
        dir(path: 'pact-provider') {
          sh 'mvn pact:verify'
        }

      }
    }

    stage('ClosePactBroker') {
      steps {
        dir(path: 'pact-broke') {
          sh 'sudo /usr/local/bin/docker-compose down -d'
        }

      }
    }

    stage('ShutdownProvider') {
      steps {
        dir(path: 'pact-provider') {
          sh 'curl -X POST localhost:8888/shutdown'
        }

      }
    }

  }
}