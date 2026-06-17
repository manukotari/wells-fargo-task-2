package com.wellsfargo.investment_management.entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "financial_advisors")
public class FinancialAdvisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advisorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "financialAdvisor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Client> clients;

    // Default Constructor
    public FinancialAdvisor() {}

    // Initializing Constructor
    public FinancialAdvisor(String firstName, String lastName, String email, List<Client> clients) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.clients = clients;
    }

    // Getters and Setters
    public Long getAdvisorId() { return advisorId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Client> getClients() { return clients; }
    public void setClients(List<Client> clients) { this.clients = clients; }
}
