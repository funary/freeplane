package org.freeplane.plugin.formula;

import org.freeplane.core.util.HtmlUtils;
import org.freeplane.features.common.map.NodeModel;
import org.freeplane.features.common.text.ITextTransformer;
import org.freeplane.plugin.script.ExecuteScriptException;
import org.freeplane.plugin.script.FormulaUtils;

class FormulaTextTransformer implements ITextTransformer {
	FormulaTextTransformer() {
	}

	// FIXME: do we actually need a null check here? - wouldn't a NPE be fine?
	public String transform(final String text, final NodeModel nodeModel) {
		final String plainText = HtmlUtils.htmlToPlain(nodeModel.getText());
		if(! FormulaUtils.containsFormula(plainText)){
			return text;
		}
		// starting a new ScriptContext in evalIfScript
		final Object result = FormulaUtils.evalIfScript(nodeModel, null, plainText);
		if (result == null) {
			throw new ExecuteScriptException("got null result from evaluating " + nodeModel.getID() + ", text='"
			        + plainText.substring(1) + "'");
		}
		return result.toString();
	}
}
