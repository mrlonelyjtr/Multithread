package activeobject;

class SearchRequest extends MethodRequest<String> {
    private final String word;

    protected SearchRequest(Servant servant, FutureResult<String> future, String word) {
        super(servant, future);
        this.word = word;
    }

    @Override
    public void execute() {
        Result<String> result = servant.search(word);
        future.setResult(result);
    }
}
