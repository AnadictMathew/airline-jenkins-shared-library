def call(String frontendDir, String bucketName, String distributionId) {
    sh """
        aws s3 sync ${frontendDir}/build/ s3://${bucketName} --delete
        aws cloudfront create-invalidation \
          --distribution-id ${distributionId} \
          --paths "/*"
    """
}