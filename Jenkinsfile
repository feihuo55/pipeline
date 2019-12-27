pipeline {
  agent any
  stages {
    stage('Compile') {
      steps {
        sh '''#!/bin/bash -il
mvn clean compile'''
      }
    }

    stage('PactBroker') {
      steps {
        dir(path: 'pact-broker') {
          sh 'sudo /usr/local/bin/docker-compose up -d'
        }

      }
    }

    stage('ContractTesting') {
      steps {
        dir(path: 'pact-consumer') {
          sh 'mvn test'
        }

      }
    }

    stage('PublishPact') {
      steps {
        sh 'mvn pact:publish'
      }
    }

  }
}