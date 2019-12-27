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
          sh 'mvn spring-boot:run'
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

  }
}