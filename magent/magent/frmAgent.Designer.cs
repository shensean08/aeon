namespace magent
{
    partial class frmAgent
    {
        /// <summary>
        /// 必要なデザイナ変数です。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 使用中のリソースをすべてクリーンアップします。
        /// </summary>
        /// <param name="disposing">マネージ リソースが破棄される場合 true、破棄されない場合は false です。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows フォーム デザイナで生成されたコード

        /// <summary>
        /// デザイナ サポートに必要なメソッドです。このメソッドの内容を
        /// コード エディタで変更しないでください。
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmAgent));
            this.axAgent = new AxAgentObjects.AxAgent();
            this.txtsay = new System.Windows.Forms.TextBox();
            this.btnsay = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.axAgent)).BeginInit();
            this.SuspendLayout();
            // 
            // axAgent
            // 
            this.axAgent.Enabled = true;
            this.axAgent.Location = new System.Drawing.Point(22, 12);
            this.axAgent.Name = "axAgent";
            this.axAgent.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("axAgent.OcxState")));
            this.axAgent.Size = new System.Drawing.Size(32, 32);
            this.axAgent.TabIndex = 0;
            // 
            // txtsay
            // 
            this.txtsay.Location = new System.Drawing.Point(112, 209);
            this.txtsay.Name = "txtsay";
            this.txtsay.Size = new System.Drawing.Size(187, 19);
            this.txtsay.TabIndex = 1;
            // 
            // btnsay
            // 
            this.btnsay.Location = new System.Drawing.Point(253, 234);
            this.btnsay.Name = "btnsay";
            this.btnsay.Size = new System.Drawing.Size(46, 24);
            this.btnsay.TabIndex = 2;
            this.btnsay.Text = "Say";
            this.btnsay.UseVisualStyleBackColor = true;
            this.btnsay.Click += new System.EventHandler(this.btnsay_Click);
            // 
            // frmAgent
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(311, 282);
            this.Controls.Add(this.btnsay);
            this.Controls.Add(this.txtsay);
            this.Controls.Add(this.axAgent);
            this.Name = "frmAgent";
            this.Text = "magent";
            this.Load += new System.EventHandler(this.frmAgent_Load);
            ((System.ComponentModel.ISupportInitialize)(this.axAgent)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private AxAgentObjects.AxAgent axAgent;
        private System.Windows.Forms.TextBox txtsay;
        private System.Windows.Forms.Button btnsay;
    }
}

