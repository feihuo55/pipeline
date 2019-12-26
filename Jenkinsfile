pipeline {
  agent any
  stages {
    stage('Compile') {
      steps {
        sh '''#!/bin/bash -il
mvn clean compile'''
      }
    }

  }
}