package io.sreepanicker.Addressbook;

import io.sreepanicker.Addressbook.model.Address;
import io.sreepanicker.Addressbook.service.AddressBook;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AddressbookApplicationTests {


    @MockBean
    private AddressBook addressBook;

    @Before
    public void setup() {
        Address addr = new Address();
        addr.setId(0);
        addr.setFirstName("firstName");
        addr.setLastName("lastName");
        addr.setStreet("street");
        addr.setProvince("ON");

        List<Address> list = new ArrayList<>();
        list.add(addr);
        try {
            given(this.addressBook.getAddressList())
                    .willReturn(list);
        } catch (Exception e) {
            System.out.println("error :" + e);
        }
    }

    @Test
    public void getAddressList() {
        try {
            Assert.assertEquals("Address list must contains one element",1, addressBook.getAddressList().size());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
