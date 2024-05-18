import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite()
@SelectClasses({CompleteTestSuite.class, DriverUnitTesting.class, MediatorTesting.class, MenuTesting.class, StrategyTesting.class, TimeSlotTesting.class, ToppingFactoryTesting.class})
public class CompleteTestSuite {
}
