package com.wellsfargo.investment_management.entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "portfolios")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @Column(name = "portfolio_name")
    private String portfolioName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Security> securities;

    // Default Constructor
    public Portfolio() {}

    // Initializing Constructor
    public Portfolio(String portfolioName, Client client, List<Security> securities) {
        this.portfolioName = portfolioName;
        this.client = client;
        this.securities = securities;
    }

    // Getters and Setters
    public Long getPortfolioId() { return portfolioId; }

    public String getPortfolioName() { return portfolioName; }
    public void setPortfolioName(String portfolioName) { this.portfolioName = portfolioName; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public List<Security> getSecurities() { return securities; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}
