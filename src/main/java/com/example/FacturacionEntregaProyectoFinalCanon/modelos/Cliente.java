package com.example.FacturacionEntregaProyectoFinalCanon.modelos;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


//entidad de cliente
@Getter
@Setter

@Entity
@Table(name="cliente")
public class Cliente {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long clienteid;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private Long documento;

    public Long getClienteid() {
        return clienteid;
    }
    public void setClienteid(Long clienteid) {
        this.clienteid = clienteid;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Long getDocumento() {
        return documento;
    }
    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cliente [");
        if (clienteid != null)
            builder.append("clienteid=").append(clienteid).append(",");
        if(documento != null)
            builder.append("documento=").append(documento);
        builder.append("]");
        return builder.toString();
    }

}

