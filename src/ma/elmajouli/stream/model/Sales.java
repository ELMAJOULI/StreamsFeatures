package ma.elmajouli.stream.model;

import java.util.Date;
import java.util.Objects;

public final  class Sales {

    private String company;
    private String casablanca;
    private Date saleYear;
    private Double price;

    public Sales(String company, String casablanca, Date saleYear, Double price) {
        this.company = company;
        this.casablanca = casablanca;
        this.saleYear = saleYear;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "company='" + company + '\'' +
                ", casablanca='" + casablanca + '\'' +
                ", saleYear=" + saleYear +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return company.equals(sales.company) &&
                casablanca.equals(sales.casablanca) &&
                saleYear.equals(sales.saleYear) &&
                price.equals(sales.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, casablanca, saleYear, price);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCasablanca() {
        return casablanca;
    }

    public void setCasablanca(String casablanca) {
        this.casablanca = casablanca;
    }

    public Date getSaleYear() {
        return saleYear;
    }

    public void setSaleYear(Date saleYear) {
        this.saleYear = saleYear;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
