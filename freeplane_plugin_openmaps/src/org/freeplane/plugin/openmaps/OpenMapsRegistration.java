package org.freeplane.plugin.openmaps;

import org.freeplane.features.mode.ModeController;
import org.freeplane.plugin.openmaps.actions.InsertOpenMapsAction;

/**
 * @author Blair Archibald 
 */
public class OpenMapsRegistration {
	
	public OpenMapsRegistration(ModeController modeController) { 
		if (modeController.getModeName() == "MindMap") {
			//Possibly employ a factory method here.
			modeController.addAction(new InsertOpenMapsAction());
		}
	}

}
