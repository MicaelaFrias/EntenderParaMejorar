package Main;

import org.kie.api.runtime.KieContainer;
import Utils.KnowledgeSessionHelper;;
public class Main {

	public static void main(String[] args) {
		KieContainer container = KnowledgeSessionHelper.createRuleBase();
	}
}
