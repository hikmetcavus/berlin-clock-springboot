package org.fm.berlinclock.controller;

import org.fm.berlinclock.model.BerlinClockModel;
import org.fm.berlinclock.service.ReproduceOfBerlinClockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BerlinClockApiControllerTest {

    @MockBean
    private ReproduceOfBerlinClockService reproduceOfBerlinClockServiceMock;

    @Autowired
    private BerlinClockApiController controller;

    @Test
    public void getBerlinRepresentationTest() throws ParseException {
        BerlinClockModel model = new BerlinClockModel();
        given(this.reproduceOfBerlinClockServiceMock.getBerlinRepresentation(anyObject())).willReturn(model);

        BerlinClockModel result = controller.getBerlinTimeRepresentation("12:29:25");
        assertThat(result).isEqualTo(model);
    }

}
