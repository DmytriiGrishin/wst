
package ru.ifmo.client;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Sculpture {

    protected String author;
    protected float height;
    protected int id;
    protected String material;
    protected String name;
    protected float width;
    protected int year;

    /**
     * Gets the value of the author property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the height property.
     */
    public float getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     */
    public void setHeight(float value) {
        this.height = value;
    }

    /**
     * Gets the value of the id property.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the material property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Sets the value of the material property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMaterial(String value) {
        this.material = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the width property.
     */
    public float getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     */
    public void setWidth(float value) {
        this.width = value;
    }

    /**
     * Gets the value of the year property.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     */
    public void setYear(int value) {
        this.year = value;
    }

    @Override
    public String toString() {
        return "Sculpture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", material='" + material + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}