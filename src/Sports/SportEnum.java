package Sports;

public enum SportEnum {
    BASKETBALL {
        public SportInterface getSport() {
            return new Basketball();
        }
    },
    HANDBALL {
        public SportInterface getSport() {
            return new Handball();
        }
    };

    public abstract SportInterface getSport();
}
