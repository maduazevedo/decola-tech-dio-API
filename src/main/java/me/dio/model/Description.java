package me.dio.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tab_description")
    public class Description {

        @Id
        private Long id_description;

        @Column(length = 50, nullable = false)
        private String module;

        @Column(length = 50, nullable = false)
        private String file;

        @Column(length = 50, nullable = false)
        private String possibleCause;

        @Column(length = 50, nullable = false)
        private String impact;


        public Long getId_description() {
            return id_description;
        }

        public void setId_description(Long id_description) {
            this.id_description = id_description;
        }

        public String getModule() {
            return module;
        }

        public void setModule(String module) {
            this.module = module;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public String getPossibleCause() {
            return possibleCause;
        }

        public void setPossibleCause(String possibleCause) {
            this.possibleCause = possibleCause;
        }

        public String getImpact() {
            return impact;
        }

        public void setImpact(String impact) {
            this.impact = impact;
        }


}



