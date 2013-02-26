using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using AxAgentObjects;
namespace magent
{
    public partial class frmAgent : Form
    {
        private AgentObjects.IAgentCtlCharacterEx Character;

        public frmAgent()
        {
            InitializeComponent();
        }

        private void frmAgent_Load(object sender, EventArgs e)
        {
            // acsPath
            String acsPath = System.Configuration.ConfigurationSettings.AppSettings["acsPath"];
            // agentName
            String agentName = System.Configuration.ConfigurationSettings.AppSettings["agentName"];

            // load agent
            this.axAgent.Characters.Load(agentName, acsPath);
            Character = axAgent.Characters[agentName];
            Character.LanguageID = 0x409;
            Character.Show(null);
        }

        private void btnsay_Click(object sender, EventArgs e)
        {
            Character.Speak(this.txtsay.Text, null);
        }
    }
}
