package com.inter12.pinellia.common.rchain;

/**
 * 责任链模式--默认的模板实现
 * 
 * @author inter12
 * @param <T>
 */
public abstract class RChainTemplateHandle<T> extends RChainHandler {

    @SuppressWarnings("unchecked")
    @Override
    public T handleRequest(RChainContext context) {
        try {

            beforerHook(context);

            T execute = (T) execute(context);

            afterHook(execute, context);

            if (!isContinue) {
                return (T) execute;
            }

        } catch (Exception e) {

        }

        return (T) getNextHandler().handleRequest(context);
    }

    public abstract T execute(RChainContext context);

    protected void beforerHook(RChainContext t) {
        // 默认实现
    }

    protected void afterHook(T t, RChainContext context) {
        // 默认实现
    }

}
