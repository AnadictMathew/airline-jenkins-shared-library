def call(String frontendDir) {
    sh """
        cd ${frontendDir}
        npm install
        npm run build
    """
}