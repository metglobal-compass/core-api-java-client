package compass_api.model.UserHotelier;

public class UserHotelier {
    private ChannelManager channelManager;
    private ChannelManagerEndpoint channelManagerEndpoint;
    private String channelManagerRateOption;

    public ChannelManager getChannelManager() {
        return channelManager;
    }

    public void setChannelManager(ChannelManager channelManager) {
        this.channelManager = channelManager;
    }

    public ChannelManagerEndpoint getChannelManagerEndpoint() {
        return channelManagerEndpoint;
    }

    public void setChannelManagerEndpoint(ChannelManagerEndpoint channelManagerEndpoint) {
        this.channelManagerEndpoint = channelManagerEndpoint;
    }

    public String getChannelManagerRateOption() {
        return channelManagerRateOption;
    }

    public void setChannelManagerRateOption(String channelManagerRateOption) {
        this.channelManagerRateOption = channelManagerRateOption;
    }
}
