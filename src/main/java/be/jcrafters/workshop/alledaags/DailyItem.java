package be.jcrafters.workshop.alledaags;

import java.util.Objects;

public class DailyItem {
    private final String title;
    private final String specific;
    private final String image;
    private final String credit;
    private final String creditName;

    private DailyItem(String title, String specific, String image, String credit, String creditName) {
        Objects.requireNonNull(title, "Title is mandatory");
        this.title = title;
        this.specific = specific;
        this.image = image;
        this.credit = credit;
        this.creditName = creditName;
    }

    public String getTitle() {
        return title;
    }

    public String getSpecific() {
        return specific;
    }

    public String getImage() {
        return image;
    }

    public String getCredit() {
        return credit;
    }

    public String getCreditName() {
        return creditName;
    }

    public static final class DailyItemBuilder {
        private String title;
        private String specific;
        private String image;
        private String credit;
        private String credit_name;

        private DailyItemBuilder() {
        }

        public static DailyItemBuilder aDailyItem() {
            return new DailyItemBuilder();
        }

        public DailyItemBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public DailyItemBuilder withSpecific(String specific) {
            this.specific = specific;
            return this;
        }

        public DailyItemBuilder withImage(String image) {
            this.image = image;
            return this;
        }

        public DailyItemBuilder withCredit(String credit) {
            this.credit = credit;
            return this;
        }

        public DailyItemBuilder withCreditName(String creditName) {
            this.credit_name = creditName;
            return this;
        }

        public DailyItem build() {
            return new DailyItem(title, specific, image, credit, credit_name);
        }
    }

    @Override
    public String toString() {
        return "DailyItem{" +
                "title='" + title + '\'' +
                ", specific='" + specific + '\'' +
                ", image='" + image + '\'' +
                ", credit='" + credit + '\'' +
                ", creditName='" + creditName + '\'' +
                '}';
    }
}
