package com.sycompla.composite;

import java.util.List;

public class FBSendMessageResponse {

    public static class Result{

        public String error;

        public String message_id;

        public Result() {}

        public Result(String error, String message_id) {
            this.error = error;
            this.message_id = message_id;
        }

        public Result(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getMessage_id() {
            return message_id;
        }

        public void setMessage_id(String message_id) {
            this.message_id = message_id;
        }

    } // Result

    public static class Root{

        public long multicast_id;

        public int success;

        public int failure;

        public int canonical_ids;

        public List<Result> results;

        public Root() {}

        public Root(long multicast_id, int success, int failure, int canonical_ids, List<Result> results) {
            this.multicast_id = multicast_id;
            this.success = success;
            this.failure = failure;
            this.canonical_ids = canonical_ids;
            this.results = results;
        }

        public long getMulticast_id() {
            return multicast_id;
        }

        public void setMulticast_id(long multicast_id) {
            this.multicast_id = multicast_id;
        }

        public int getSuccess() {
            return success;
        }

        public void setSuccess(int success) {
            this.success = success;
        }

        public int getFailure() {
            return failure;
        }

        public void setFailure(int failure) {
            this.failure = failure;
        }

        public int getCanonical_ids() {
            return canonical_ids;
        }

        public void setCanonical_ids(int canonical_ids) {
            this.canonical_ids = canonical_ids;
        }

        public List<Result> getResults() {
            return results;
        }

        public void setResults(List<Result> results) {
            this.results = results;
        }

    } // Root

} // FBSendMessageResponse