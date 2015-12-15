

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RenderableHolder {

	private static final RenderableHolder instance = new RenderableHolder();
	private List<IRenderable> objectOnScreen = new CopyOnWriteArrayList<IRenderable>();

	public static RenderableHolder getInstance() {
		return instance;
	}

//	public RenderableHolder() {
//		super();
//	}

	public void add(IRenderable obj) {
		objectOnScreen.add(obj);
		Collections.sort(objectOnScreen, new Comparator<IRenderable>() {

			@Override
			public int compare(IRenderable o1, IRenderable o2) {
				return Integer.compare(o1.getZ(), o2.getZ());
			}

		});

	}

	public List<IRenderable> getRenderableList() {
		return objectOnScreen;
	}
}
