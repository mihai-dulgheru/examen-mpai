package designPatterns.mediator;

/**
 * Common component interface.
 */
public interface Component {
    void setMediator(Mediator mediator);

    String getName();
}
