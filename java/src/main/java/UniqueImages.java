import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class UniqueImages {
    public static class Image {
        private String filename;
        private int width;
        private int height;
        public Image(String filename, int width, int height) {
            this.filename = filename;
            this.width = width;
            this.height = height;
        }
        /**
         * Two Images are considered equal if they have
         * the same filename (without the extension), and the
         * same number of pixels.
         * Thus, flag.jpg with width=60 height=40 is
         * equal to flag.gif with width=40 and height=60
         */
        public boolean equals(Object other) {
            Image o = (Image)other;
            if (filename == null || o.filename == null)
                return false;
            String[] components = filename.split("\\.");
            String[] ocomponents = o.filename.split("\\.");
            return components[0].equalsIgnoreCase(ocomponents[0]) &&
                    width * height == o.width * o.height;
        }

        /**
         * We have to maintain the hashcode and equals contract.
         * if we have overridden equals() we must override hashcode() as well.
         *
         * Since in equals() only fileName(without extension) and total pixels(width * height)
         * is taken into consideration. Same fields must be use in calculating hashcode
         *
         */
        @Override
        public int hashCode() {
            // taking filename in lowercase, making case insensitive.
            return Objects.hash(filename.split("\\.")[0].toLowerCase(), width * height);
        }

        public String toString() {
            return "Image: filename=" + filename + " Size=" + width*height;
        }
    }

    public static void printImages(Set<Image> images) {
        for(Image image: images) {
            System.out.println(image);
        }
    }

    public static void main(String[] args) {
        // It is mentioned that only fileName(without Extension) and Pixels are to be considered for equality.
        // but what about Same File name with different case? as it could be something intentional.
        // for sake of complete uniqueness I am assuming, that Filename are same irrespective of the case.
        // So used equalIgnorecase in equals() and toLowerCase() in hashCode()
        //
        Image[] images = {new Image("flag.jpg", 40, 60),
                new Image("flag.gif", 40, 60),
                new Image("smile.gif", 100, 200),
                new Image("smile.gif", 50, 400),
                new Image("other.jpg", 40, 60),
                new Image("lenna.jpg", 512, 512),
                new Image("Lenna.jpg", 512, 512)};
        Set<Image> set = new HashSet<Image>(Arrays.asList(images));
        UniqueImages.printImages(set);
    }
}
