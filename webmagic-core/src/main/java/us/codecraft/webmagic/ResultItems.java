package us.codecraft.webmagic;

import java.util.HashMap;
import java.util.Map;

/**
 * Object contains extract results.<br>
 * It is contained in Page and will be processed in pipeline.
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.1.0
 * @see Page
 * @see us.codecraft.webmagic.pipeline.Pipeline
 */
public class ResultItems {

    private Map<String, Object> fields = new HashMap<String, Object>();
    
    private Map<String, String> httpHeaderResponses = new HashMap<String, String>();

    private Request request;

    private boolean skip;

    @SuppressWarnings("unchecked")
	public <T> T get(String key) {
        Object o = fields.get(key);
        if (o == null) {
            return null;
        }
        return (T) fields.get(key);
    }

    public Map<String, Object> getAll() {
        return fields;
    }

    public <T> ResultItems put(String key, T value) {
        fields.put(key, value);
        return this;
    }

    public Request getRequest() {
        return request;
    }

    public ResultItems setRequest(Request request) {
        this.request = request;
        return this;
    }
    
    public ResultItems putHttpHeaderResponse(String key, String value) {
    	this.httpHeaderResponses.put(key, value);
    	return this;
    }
    
    public String getHttpHeaderResponse(String key) {
    	return this.httpHeaderResponses.get(key);
    }
    
    public Map<String, String> getAllHttpHeaderResponses() {
    	return this.httpHeaderResponses;
    }

    /**
     * Whether to skip the result.<br>
     * Result which is skipped will not be processed by Pipeline.
     *
     * @return whether to skip the result
     */
    public boolean isSkip() {
        return skip;
    }


    /**
     * Set whether to skip the result.<br>
     * Result which is skipped will not be processed by Pipeline.
     *
     * @param skip whether to skip the result
     * @return this
     */
    public ResultItems setSkip(boolean skip) {
        this.skip = skip;
        return this;
    }
}
