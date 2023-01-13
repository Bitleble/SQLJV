package demo.Tables;
import java.util.Objects;

public class Base {


    // Базовый класс модели, имеющий ключ id
        protected long id;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public Base() {}

        public Base(long id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Base baseModel = (Base) o;
            return id == baseModel.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }


}
