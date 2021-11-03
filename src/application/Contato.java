package application;

import java.util.Objects;

public class Contato {
    private String name;
    private String contact;

    public Contato(){
    }

    public Contato( String name, String contact) {
        this.name = name;
        this.contact = contact;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato)) return false;
        Contato contato = (Contato) o;
        return getName().equals(contato.getName()) && getContact().equals(contato.getContact());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getContact());
    }

    @Override
    public String toString() {
        return "{" +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
