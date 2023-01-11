/**
 * <p>
 * Test para probar la clase ExcelReportManager
 * </p>
 * 
 * @author Iv�n Matas Gonz�lez
 *
 */
package us.muit.fs.a4i.test.persistence;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import us.muit.fs.a4i.model.entities.ReportItem;
import us.muit.fs.a4i.persistence.ExcelReportManager;
import us.muit.fs.a4i.persistence.ReportFormaterI;

@ExtendWith(MockitoExtension.class)

class ExcelReportManagerTest {
	private static Logger log = Logger.getLogger(ExcelReportManager.class.getName());

	@Captor
	private ArgumentCaptor<Integer> intCaptor;
	@Captor
	private ArgumentCaptor<String> strCaptor;
	@Captor
	private ArgumentCaptor<ReportFormaterI> FormaterCaptor;

	@Mock(serializable = true)
	private static ReportItem<Integer> metricIntMock = Mockito.mock(ReportItem.class);
	@Mock(serializable = true)
	private static ReportItem<String> metricStrMock = Mockito.mock(ReportItem.class);

	@Test
	void ExcelCreation() {

	}
}