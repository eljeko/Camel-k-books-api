# Run the integration

kamel run --name booksapi BooksApi.java --open-api openapi.yaml -d mvn:com.github.javafaker:javafaker:0.17.2

# get the url

URL=$(oc get routes.serving.knative.dev booksapi -o jsonpath='{.status.url}')

echo $URL

curl -i $URL/

curl -i $URL/book

curl -i $URL/list