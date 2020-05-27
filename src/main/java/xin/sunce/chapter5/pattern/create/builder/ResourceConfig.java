package xin.sunce.chapter5.pattern.create.builder;

/**
 * 建造者模式
 * 保存资源配置不会被篡改；
 * 避免资源配置的无效状态，或者错误配置
 * 参数配置较多时，降低构造函数的复杂性
 * 支持链式编程
 *
 * @author lowrie
 * @date 2020-05-12
 */
public class ResourceConfig {

    private long timeout;
    private boolean retry;
    private long maxTotal;
    private long maxIdle;

    private ResourceConfig(Builder builder) {
        this.timeout = builder.timeout;
        this.retry = builder.retry;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
    }

    public long getTimeout() {
        return timeout;
    }

    public boolean isRetry() {
        return retry;
    }

    public long getMaxTotal() {
        return maxTotal;
    }

    public long getMaxIdle() {
        return maxIdle;
    }

    @Override
    public String toString() {
        return "ResourceConfig{" +
                "timeout=" + timeout +
                ", retry=" + retry +
                ", maxTotal=" + maxTotal +
                ", maxIdle=" + maxIdle +
                '}';
    }

    public static class Builder {
        private static final long DEFAULT_TIMEOUT = 60;
        private static final boolean DEFAULT_RETRY = false;
        private static final long DEFAULT_MAX_TOTAL = 10;
        private static final long DEFAULT_MAX_IDLE = 120;

        private long timeout = DEFAULT_TIMEOUT;
        private boolean retry = DEFAULT_RETRY;
        private long maxTotal = DEFAULT_MAX_TOTAL;
        private long maxIdle = DEFAULT_MAX_IDLE;

        public Builder setTimeout(long timeout) {
            if (timeout <= 0) {
                throw new IllegalArgumentException("invalid timeout");
            }
            this.timeout = timeout;
            return this;
        }

        public Builder setRetry(boolean retry) {
            this.retry = retry;
            return this;
        }

        public Builder setMaxTotal(long maxTotal) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("invalid maxTotal");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(long maxIdle) {
            if (maxIdle <= 0) {
                throw new IllegalArgumentException("invalid maxIdle");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        /**
         * 构建事校验逻辑规则
         * 例如：组合生效的规则
         *
         * @return 目标对象
         */
        public ResourceConfig build() {
            if (timeout <= 0) {
                throw new IllegalArgumentException("invalid timeout");
            }
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("invalid maxTotal");
            }
            if (maxIdle <= 0) {
                throw new IllegalArgumentException("invalid maxIdle");
            }
            return new ResourceConfig(this);
        }
    }

}
