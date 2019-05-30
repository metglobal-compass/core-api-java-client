package compass_api.model.UserHotelier;

public class UserHotelier {
	private ChannelManager channelManager;
	private String channelManagerRateOption;

	public ChannelManager getChannelManager() {
		return channelManager;
	}

	public void setChannelManager(ChannelManager channelManager) {
		this.channelManager = channelManager;
	}

	public String getChannelManagerRateOption() {
		return channelManagerRateOption;
	}

	public void setChannelManagerRateOption(String channelManagerRateOption) {
		this.channelManagerRateOption = channelManagerRateOption;
	}
}
