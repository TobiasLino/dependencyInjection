package br.tobalino.core.component;

import br.tobalino.model.ComponentContext;

public final class ComponentInstance {

    private static volatile ComponentInstance instance;
    private static ComponentGenerator generator;

    private ComponentContext component;

    public ComponentInstance(final ComponentContext component) {
        this.component = component;
    }

    public static ComponentInstance getInstance() {
        ComponentInstance result = instance;
        if (result != null) {
            return result;
        }
        synchronized (ComponentInstance.class) {
            if (instance == null) {
                instance = new ComponentInstance(generator.initialize());
            }
            return instance;
        }
    }
}
