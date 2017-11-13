package liugh.test_JavaDesignMode.行为模式.观察者模式.observer;

/**
 * 具体主题或通知者
 *
 */
public class ConcreteSubject extends Subject {
    private String subjectState;

    public String getSubjectState() {
	return subjectState;
    }

    public void setSubjectState(String subjectState) {
	this.subjectState = subjectState;
    }
}
