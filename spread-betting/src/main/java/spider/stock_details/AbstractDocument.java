package spider.stock_details;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;

public class AbstractDocument {

    @Id protected BigInteger id;

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }

}
